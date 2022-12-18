const http = require('http');
const fs = require('fs');
const url = require('url');
const qs = require('querystring');

const parseCookies = (cookie = '') =>
    cookie
    .split(';')
    .map(v => v.split('='))
    .map(([k, ...vs]) => [k, vs.join('=')])
    .reduce((acc, [k, v]) => {
        acc[k.trim()] = decodeURIComponent(v);
        return acc;
    }, {});

http.createServer((req,res) => {
    const cookies = parseCookies(req.headers.cookie);

    if(req.url.startsWith('/login')) { // 주소가 /login으로 시작할 경우
        const {query} = url.parse(req.url); // 각 주소와 주소에 같이오는 query 분석
        const {name} = qs.parse(query);
        res.writeHead(302, { // 페이지 새로고침시 리다이렉트 주소와 함께 쿠키를 헤더에 넣기
            Location:'/', //쿠기 사용 path
            'Set-Cookie' : `name=${encodeURIComponent(name)}; Expires=${new Date( Date.now() + 30 * 60 * 1000).toUTCString()};HttpOnly;Path=/`,
        });
        res.end();
    } else if (cookies.name) { //쿠키 판별
        res.writeHead(200, {'Content-type': 'text/html; charset=utf-8'});
        res.end(`${cookies.name}님 하이요`);
    } else { //쿠키가 없다면 로그인 페이지로 던지기
        fs.readFile('./server4.html', (err,data) => {
            if (err) {
                throw err;
            }
            res.end(data);
        })
    }
}).listen(5000, () => {
    console.log('5000번 포트에서 서버 대기 중');
})