const express = require('express');
const path = require('path');
const app = express();
const port = 3000;

// 'build' 디렉토리 내의 파일을 정적 파일로 제공
app.use(express.static('public'));


app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
