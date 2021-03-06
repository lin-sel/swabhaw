// Copyright 2019 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// Package debug exports debug information for gopls.
package debug

import (
	"fmt"
	"io"
	"os/exec"
	"strings"
)

type PrintMode int

const (
	PlainText = PrintMode(iota)
	Markdown
	HTML
)

// Version is a manually-updated mechanism for tracking versions.
var Version = "v0.3.0"

// PrintServerInfo writes HTML debug info to w for the Instance s.
func PrintServerInfo(w io.Writer, s Instance) {
	section(w, HTML, "Server Instance", func() {
		fmt.Fprintf(w, "Start time: %v\n", s.StartTime())
		fmt.Fprintf(w, "LogFile: %s\n", s.Logfile())
		fmt.Fprintf(w, "Working directory: %s\n", s.Workdir())
		fmt.Fprintf(w, "Address: %s\n", s.Address())
		fmt.Fprintf(w, "Debug address: %s\n", s.Debug())
	})
	PrintVersionInfo(w, true, HTML)
}

// PrintVersionInfo writes version and environment information to w, using the
// output format specified by mode. verbose controls whether additional
// information is written, including section headers.
func PrintVersionInfo(w io.Writer, verbose bool, mode PrintMode) {
	if !verbose {
		printBuildInfo(w, false, mode)
		return
	}
	section(w, mode, "Build info", func() {
		printBuildInfo(w, true, mode)
	})
	fmt.Fprint(w, "\n")
	section(w, mode, "Go info", func() {
		cmd := exec.Command("go", "version")
		cmd.Stdout = w
		cmd.Run()
		fmt.Fprint(w, "\n")
		cmd = exec.Command("go", "env")
		cmd.Stdout = w
		cmd.Run()
	})
}

func section(w io.Writer, mode PrintMode, title string, body func()) {
	switch mode {
	case PlainText:
		fmt.Fprintln(w, title)
		fmt.Fprintln(w, strings.Repeat("-", len(title)))
		body()
	case Markdown:
		fmt.Fprintf(w, "#### %s\n\n```\n", title)
		body()
		fmt.Fprintf(w, "```\n")
	case HTML:
		fmt.Fprintf(w, "<h3>%s</h3>\n<pre>\n", title)
		body()
		fmt.Fprint(w, "</pre>\n")
	}
}
