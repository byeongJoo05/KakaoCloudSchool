// html을 읽어 서버에 등록하는 법

const http = require('http');
const fs = require('fs');

http.createServer((req, res) => {
    fs.readFile('./server2.html', (err, data) =>{
        if (err) {
            throw err;
        }
        res.end(data);
    });
}).listen(5000, () => {
    console.log('5000번 포트에서 서버 대기중');
})