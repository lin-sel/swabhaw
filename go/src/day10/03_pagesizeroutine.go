package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"sync"
)

type page struct {
	Size int
	link string
	error
}

var wait sync.WaitGroup

func main() {

	ch := make(chan page)
	url := []string{"http://swabh/", "https://godoc.org/github.com/golang-china/golangdoc", "https://www.google.com"}

	for i := 0; i < len(url); i++ {
		wait.Add(1)
		go pagesize(ch, url[i])
	}

	for i := 0; i < len(url); i++ {
		sd := <-ch
		// printDetail(sd)
		sd.printDetail()
	}

	wait.Wait()
}

func pagesize(ch chan<- page, url string) {
	defer wait.Done()
	defer func() {
		if e := recover(); e != nil {
		}
	}()
	resp, err := http.Get(url)
	if err != nil {
		ch <- page{0, url, err}
	}
	sb, er := ioutil.ReadAll(resp.Body)
	if er != nil {
		ch <- page{0, url, er}
	}
	length := len(sb)
	ch <- page{length, url, nil}
}

func (pg *page) printDetail() {
	if pg.error != nil {
		fmt.Println(pg.Error())
	}
	fmt.Println(pg.Size, pg.link)
}
