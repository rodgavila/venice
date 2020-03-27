package com.aquitraslomita.venice.processor;

import java.lang.System;

/**
 * This processor generates a `CanInjectFoo` interface for each annotated class.
 *
 * Example:
 *
 * ```
 * @ExampleAnnotation
 * class Bar {
 *
 * }
 * ```
 *
 * will generate a CanInjectBar.kt file containing:
 *
 * ```
 * interface CanInjectBar {
 *   fun inject(obj: Bar)
 * }
 * ```
 */
@com.google.auto.service.AutoService(value = {javax.annotation.processing.Processor.class})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0016\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u000e0\u000e0\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!H\u0016J(\u0010\"\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/aquitraslomita/venice/processor/ExampleAnnotationProcessor;", "Ljavax/annotation/processing/AbstractProcessor;", "()V", "elements", "Ljavax/lang/model/util/Elements;", "filer", "Ljavax/annotation/processing/Filer;", "messager", "Ljavax/annotation/processing/Messager;", "types", "Ljavax/lang/model/util/Types;", "generatedKotlinSpec", "Lcom/squareup/kotlinpoet/FileSpec;", "pack", "", "annotatedElementType", "Ljavax/lang/model/type/TypeMirror;", "interfaceName", "getSupportedAnnotationTypes", "", "kotlin.jvm.PlatformType", "getSupportedSourceVersion", "Ljavax/lang/model/SourceVersion;", "init", "", "processingEnvironment", "Ljavax/annotation/processing/ProcessingEnvironment;", "process", "", "annotations", "", "Ljavax/lang/model/element/TypeElement;", "roundEnv", "Ljavax/annotation/processing/RoundEnvironment;", "writeKotlin", "venice-annotation-processor"})
public final class ExampleAnnotationProcessor extends javax.annotation.processing.AbstractProcessor {
    private javax.annotation.processing.Filer filer;
    private javax.annotation.processing.Messager messager;
    private javax.lang.model.util.Elements elements;
    private javax.lang.model.util.Types types;
    
    @java.lang.Override()
    public synchronized void init(@org.jetbrains.annotations.NotNull()
    javax.annotation.processing.ProcessingEnvironment processingEnvironment) {
    }
    
    @java.lang.Override()
    public boolean process(@org.jetbrains.annotations.NotNull()
    java.util.Set<? extends javax.lang.model.element.TypeElement> annotations, @org.jetbrains.annotations.NotNull()
    javax.annotation.processing.RoundEnvironment roundEnv) {
        return false;
    }
    
    private final void writeKotlin(java.lang.String pack, javax.lang.model.type.TypeMirror annotatedElementType, java.lang.String interfaceName, javax.annotation.processing.Filer filer) {
    }
    
    private final com.squareup.kotlinpoet.FileSpec generatedKotlinSpec(java.lang.String pack, javax.lang.model.type.TypeMirror annotatedElementType, java.lang.String interfaceName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.Set<java.lang.String> getSupportedAnnotationTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public javax.lang.model.SourceVersion getSupportedSourceVersion() {
        return null;
    }
    
    public ExampleAnnotationProcessor() {
        super();
    }
}