package main

import (
	"bytes"
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"os"
	"strings"
	"sync"
)

// Response Http
type Response struct {
	content *http.Response
	url     string
	error
}

func main() {
	var wait sync.WaitGroup
	channel := make(chan Response)
	urls := []string{"http://www.swabhavtechlabs.com/", "https://www.javatpoint.com"}
	wait.Add(len(urls))
	for _, url := range urls {
		go service(url, &wait, channel)
	}
	wait.Wait()
}

func createFile(name string) (*os.File, error) {
	file := strings.Split(name, ".")
	return os.Create(file[1])
}

func readContent(url string, channel chan Response) {
	resp, err := http.Get(url)
	channel <- Response{resp, url, err}
}

func service(url string, wait *sync.WaitGroup, channel chan Response) {
	defer func() {
		if err := recover(); err != nil {
		}
	}()
	defer wait.Done()
	go readContent(url, channel)
	resp := <-channel
	file, err := createFile(resp.url)
	if err != nil {
		fmt.Println(err)
	}

	cont, reader := typeConvert(resp.content.Body)
	screenPrint(cont)
	defer file.Close()

	if resp.error != nil {
		fmt.Println(resp.error.Error())
	}
	_, werr := writeToFile(file, reader)
	if werr != nil {
		fmt.Println(werr)
	}
}

func writeToFile(w *os.File, content io.ReadCloser) (int64, error) {
	return io.Copy(w, content)
}

func screenPrint(resp []byte) {
	fmt.Println(string(resp))
}

func typeConvert(content io.ReadCloser) ([]byte, io.ReadCloser) {
	cont, _ := ioutil.ReadAll(content)
	reader := ioutil.NopCloser(bytes.NewBuffer(cont))
	return cont, reader
}
