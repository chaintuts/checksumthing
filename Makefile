# This file contains a make script for the CheckSumthing application
#
# Author: Josh McIntyre
#

SRC_FILES=src/com/jmcintyre/*.java
PKG=com.jmcintyre
PKG_PATH=com/jmcintyre
PKG_SUBPATH=com
ENTRY_CLASS=CheckSumthing

OBJ_DIR=obj
BUILD_DIR=bin
BUILD_BIN=checksumthing.jar

CC=javac
PKGR=jar

# This rule builds the application
build: $(SRC_FILES)
	mkdir -p $(BUILD_DIR)
	mkdir -p $(OBJ_DIR)
	$(CC) -d $(OBJ_DIR) $(SRC_FILES)
	cd $(OBJ_DIR); $(PKGR) cfe ../$(BUILD_DIR)/$(BUILD_BIN) $(PKG).$(ENTRY_CLASS) $(PKG_PATH)/*

# This rule cleans the build directory
clean: $(BUILD_DIR)
	rm $(BUILD_DIR)/*
	rmdir $(BUILD_DIR)
	rm $(OBJ_DIR)/$(PKG_PATH)/*
	rmdir $(OBJ_DIR)/$(PKG_PATH)
	rmdir $(OBJ_DIR)/$(PKG_SUBPATH)
	rmdir $(OBJ_DIR) 
