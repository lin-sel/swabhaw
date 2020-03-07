FROM golang:latest

RUN mkdir /build

WORKDIR /build

COPY go.mod .

COPY . .

RUN go mod download

RUN go build -o main .

CMD ["/build/main"]