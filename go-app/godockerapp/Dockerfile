FROM golang:latest

ENV GO111MODULE=on
RUN mkdir /build
WORKDIR /build

COPY go.mod .
RUN go mod download
COPY . .
RUN go build -o main .
CMD ["/build/main"]

