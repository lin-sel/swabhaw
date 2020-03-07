FROM golang:1.13

ENV GO111MODULE=on

RUN mkdir /var/www/server

WORKDIR /build

COPY go.mod .

RUN go mod download

COPY . .

RUN go build -o main .

CMD ["/var/www/main"]