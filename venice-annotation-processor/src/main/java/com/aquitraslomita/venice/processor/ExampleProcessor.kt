package com.aquitraslomita.venice.processor

import com.google.auto.service.AutoService
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Filer
import javax.annotation.processing.Messager
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeMirror
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import javax.tools.Diagnostic

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
 *    fun inject(obj: Bar)
 * }
 * ```
 */
@AutoService(Processor::class)
class ExampleAnnotationProcessor : AbstractProcessor() {

    private lateinit var filer: Filer
    private lateinit var messager: Messager
    private lateinit var elements: Elements
    private lateinit var types: Types

    @Synchronized
    override fun init(processingEnvironment: ProcessingEnvironment) {
        filer = processingEnvironment.filer
        messager = processingEnvironment.messager
        elements = processingEnvironment.elementUtils
        types = processingEnvironment.typeUtils
    }

    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        roundEnv.getElementsAnnotatedWith(ExampleAnnotation::class.java).forEach { annotatedElement ->


            val typeElement = annotatedElement as TypeElement

            val pack = elements.getPackageOf(annotatedElement).toString()

            val genInterfaceName = "CanInject${typeElement.simpleName}"

            writeKotlin(pack, typeElement.asType(), "${genInterfaceName}Kotlin", filer)
            writeJava(pack, typeElement.asType(), "${genInterfaceName}Java", filer)
        }

        return true
    }

    private fun writeKotlin(pack: String, annotatedElementType: TypeMirror, interfaceName: String, filer: Filer) {
        val fileSpec = generatedKotlinSpec(pack, annotatedElementType, interfaceName)

        fileSpec.writeTo(filer)
    }

    private fun generatedKotlinSpec(pack: String, annotatedElementType: TypeMirror, interfaceName: String): FileSpec {
        val fileBuilder = FileSpec.builder(pack, interfaceName)

        val interfaceSpec = TypeSpec.interfaceBuilder(interfaceName)
            .addFunction(
            FunSpec.builder("inject")
                .addParameter(ParameterSpec.builder(
                    "obj",
                    annotatedElementType.asTypeName()
                ).build()
                )
                .build()
        ).build()

        fileBuilder.addType(interfaceSpec)

        return fileBuilder.build()
    }

    private fun writeJava(pack: String, annotatedElementType: TypeMirror, interfaceName: String, filer: Filer) {
        val fileSpec = generateJavaSpec(pack, annotatedElementType, interfaceName)

        fileSpec.writeTo(filer)
    }

    private fun generateJavaSpec(
        pack: String,
        annotatedElementType: TypeMirror,
        interfaceName: String
    ): com.squareup.javapoet.JavaFile {
        val interfaceSpec = com.squareup.javapoet.TypeSpec.interfaceBuilder(interfaceName)
            .addModifiers(Modifier.PUBLIC)
            .addMethod(
                com.squareup.javapoet.MethodSpec.methodBuilder("inject")
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .addParameter(com.squareup.javapoet.ParameterSpec.builder(
                        com.squareup.javapoet.TypeName.get(annotatedElementType),
                        "obj")
                        .build())
                    .build()
            ).build()

        return com.squareup.javapoet.JavaFile.builder(pack, interfaceSpec).build()
    }

    override fun getSupportedAnnotationTypes() = setOf(ExampleAnnotation::class.java.canonicalName)

    override fun getSupportedSourceVersion(): SourceVersion = SourceVersion.latestSupported()
}
