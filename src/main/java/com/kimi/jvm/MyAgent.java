package com.kimi.jvm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.tree.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import static org.springframework.asm.Opcodes.*;

/**
 * @author Kimi
 * @date 2021/5/23 15:21
 */
public class MyAgent {

    public static void premain(String args, Instrumentation instrumentation) {
        instrumentation.addTransformer(new MyTransformer());
    }

    static class MyTransformer implements ClassFileTransformer {
        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassNode classNode = new ClassNode(ASM7);
            cr.accept(classNode, ClassReader.SKIP_FRAMES);

            for (MethodNode methodNode : classNode.methods) {
                if ("main".equals(methodNode.name)) {
                    InsnList instrumentation = new InsnList();
                    instrumentation.add(new FieldInsnNode(GETSTATIC, "java/lang/System", "out", "printf"));
                    instrumentation.add(new LdcInsnNode("Hello, instrumentation!"));
                    instrumentation.add(new MethodInsnNode(INVOKEVIRTUAL, "java/io/PrintStream", "println", "println"));
                    methodNode.instructions.insert(instrumentation);
                }
            }

            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            classNode.accept(cw);
            return cw.toByteArray();
        }

//        @Override
//        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//            System.out.printf("loaded %s: 0x%x%x%x%x\n",
//                    className,
//                    classfileBuffer[0],
//                    classfileBuffer[1],
//                    classfileBuffer[2],
//                    classfileBuffer[3]);
//            return null;
//        }
    }
}
