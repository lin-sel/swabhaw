FROM golang:1.13
RUN mkdir /app
WORKDIR /app
COPY go.mod .
RUN go mod download
COPY . .
RUN go build -o main .
CMD ["/app/main"]
