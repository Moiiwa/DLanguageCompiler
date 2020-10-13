.class public GeneratedProgram
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
    .limit stack 5
	.limit locals 1000
	ldc 3.0
	fstore 1

    ldc 9.0
    fstore 2

    fload 2
    ldc 3.0
    fmul
    fstore 2
    return
.end method