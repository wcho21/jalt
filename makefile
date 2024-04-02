JAVAC:=javac
JAVAC_FLAGS:=-Xlint:unchecked
JAVA:=java

PACKAGE:=jalt

SRC_DIR:=./src
DIST_DIR:=./dist
DATA_DIR:=./data
CLASSPATH:=./dist
DIST_PACKAGE_PATH=$(DIST_DIR)/$(PACKAGE)

SRC:=ArrayStack ListStack ListQueue
BUILD_TARGETS:=$(foreach S,$(SRC),$(DIST_DIR)/$(PACKAGE)/$S.class)

define dist-files
	$(foreach F,$1,$(DIST_PACKAGE_PATH)/$F.class)
endef

define run-test
	$(JAVA) -cp $(DIST_DIR) $(PACKAGE).$1 < $(DATA_DIR)/$2
endef

.PHONY: build
build: $(BUILD_TARGETS)

$(DIST_PACKAGE_PATH)/%.class: $(SRC_DIR)/%.java
	$(JAVAC) $(JAVAC_FLAGS) -cp $(CLASSPATH) -d $(DIST_DIR) $<

$(DIST_PACKAGE_PATH)/ArrayStack.class: $(SRC_DIR)/ArrayStack.java \
	$(call dist-files,Stack ArrayReverseIterator)

$(DIST_PACKAGE_PATH)/ListStack.class: $(SRC_DIR)/ListStack.java \
	$(call dist-files,Stack ListNode ListIterator)

$(DIST_PACKAGE_PATH)/ListQueue.class: $(SRC_DIR)/ListQueue.java \
	$(call dist-files,Queue ListNode ListIterator)

# example: make test class=ArrayStack input=loremShort.txt
.PHONY: test
test: $(DIST_PACKAGE_PATH)/$(class).class
	$(call run-test,$(class),$(input))

.PHONY: clean
clean:
	rm -rf $(DIST_DIR)
