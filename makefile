JAVAC:=javac
JAVAC_FLAGS:=-Xlint:unchecked
JAVA:=java

PACKAGE:=jalt

SRC_DIR:=./src
DIST_DIR:=./dist
DATA_DIR:=./data
CLASSPATH:=./src

SRC:=ArrayStack
BUILD_TARGETS:=$(foreach S,$(SRC),${DIST_DIR}/${PACKAGE}/$S.class)

.PHONY: build
build: ${BUILD_TARGETS}

${DIST_DIR}/${PACKAGE}/ArrayStack.class: ${SRC_DIR}/ArrayStack.java ${SRC_DIR}/Stack.java ${SRC_DIR}/ArrayReverseIterator.java
	${JAVAC} ${JAVAC_FLAGS} -d ${DIST_DIR} $^

.PHONY: testArrayStack
testArrayStack: ${DIST_DIR}/${PACKAGE}/ArrayStack.class
	${JAVA} -cp ${DIST_DIR} ${PACKAGE}.ArrayStack < ${DATA_DIR}/loremShort.txt

.PHONY: clean
clean:
	rm -rf ${DIST_DIR}
