//쿠키 생성해서 서버에 서버 올리기
const http = require('http');

const parseCookies = (cookie='') =>
    cookie
    .split(';')
    .map(v=>v.split('='))
    .map(([k, ...vs]) => [k, vs.join('=')])
    .reduce((acc, [k, v]) => {
        acc[k.trim()] = decodeURIComponent(v);
        return acc;
    }, {});

http.createServer((req, res) => {
    const cookies = parseCookies(req.headers.cookie); //클라이언트에서 요청받은 쿠키를 읽어서 파싱해서 cookie 변수로 저장
    console.log(req.url, cookies);
    res.writeHead(200, {'Set-Cookie':'mycookie=test'}); //응답헤더에 쿠키를 기록
    res.end('Hello Cookie');
}).listen(5000, () => {
    console.log('5000번 포트에서 서버 대기중');
});