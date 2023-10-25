// code by 유율현
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = undefined;


rl.on('line', function(line){ 
    input = line.trim().split(/\s+/).map((e)=> parseInt(e));
    rl.close();  
});

rl.on("close", function () {
    let a = input[0], dan, mul;

    console.log(`열의 개수: ${a}`);

    
    for (i = 0; i <= a; i++) {
        // x1 ~ x9 출력
        for (mul = 1; mul < 10; mul++) {
            // 단 출력
            for (dan = 2 + (i * a); dan <= a + 1  + (i * a); dan++){
                if (dan <= 9) process.stdout.write(`${dan} * ${mul} = ${dan * mul}\t`)
            }
            console.log();
        }
        console.log();
    };   

});

