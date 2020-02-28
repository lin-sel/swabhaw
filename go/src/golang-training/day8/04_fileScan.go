package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"strings"
)

func main() {
	fileScan("parent")
}

func fileScan(parent string) {
	fmt.Println(parent)
	files, err := ioutil.ReadDir(parent)
	if err != nil {
		fmt.Println(err)
	}

	for _, f := range files {
		if isDir(f) {
			fileScan(joinString(parent, f))
			continue
		}
		fmt.Println(joinString(parent, f))
	}
}

func isDir(file os.FileInfo) bool {
	mode := file.Mode()
	return mode.IsDir()
}

func joinString(parent string, child os.FileInfo) string {
	return strings.Join([]string{parent, child.Name()}, "/")
}
