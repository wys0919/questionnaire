window.onload = function () {

//       原41题填写功能，先不用
//       let q41A = document.getElementById("q41A");
//       let q41B = document.getElementById("q41B");
//       let q41C = document.getElementById("q41C");
//       let q41D = document.getElementById("q41D");
//       let q41E = document.getElementById("q41E");
//       let q41F = document.getElementById("q41F");
//       let q41FF = document.getElementById("q41FF");
//
//       bounding(q41F, q41FF);
//       leave(q41A, q41FF)
//       leave(q41B, q41FF)
//       leave(q41C, q41FF)
//       leave(q41D, q41FF)
//       leave(q41E, q41FF)
//
//       function bounding(ele, elee) {
//               ele.addEventListener("click", function () {
//                   if (ele.checked === true) {
//                       elee.disabled = false;
//                       elee.focus();
//                   } else {
//                       elee.disabled = true;
//                   }
//               })
//       }
//
//       function leave(ele, elee) {
//            ele.addEventListener("click", function () {
//                   elee.disabled = true;
//            })
//       }







//
        let radios = document.getElementsByTagName("input");
        let radioSet = new Set();
        let radioNum = 45;
        let form=document.getElementById("form");

        let submitBtn = document.getElementById("submitBtn");
//


    check(radios);
    submitBtn.addEventListener("click", function (event) {
        event.preventDefault();
        console.log([...radioSet].length,radioNum)
        if ([...radioSet].length < radioNum) {
            alert("问卷未填写完整");
        }else{
            //if (confirm("不再更改")){
                form.submit();
            //}

        }
    });



        function check(radios) {
            for (let r of radios) {

                r.addEventListener("change", function () {
                    radioSet.add(r.name);
                })
            }
        }


//


};