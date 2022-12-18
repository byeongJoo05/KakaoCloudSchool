const http = require('http');

const server = http.createServer((req, res) => {
    res.write('<h1>Hello Node</h1>');
    res.end('<p>Hello Server!</p1>');
});

server.listen(5000);

server.on('listening', () => {
    console.log('5000번 포트에서 서버 대기중');
});

server.on('error', (error) => {
    console.error(error);
});