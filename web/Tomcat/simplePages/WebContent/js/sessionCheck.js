function openWindow(){
	var popup=document.getElementById("popup");
	popup.style.display="block";
}

function closeWindow(){
	var popup=document.getElementById("popup");
	popup.style.display="hidden";
}

var tid;
var cnt=parseInt(10);

function CountInit(){
	tid=setInterval("CountRun()",1000);
}

function CountRun(){
	document.all.counter.innerText=timeFormat(cnt);
	cnt--;
	if(cnt<0){
		clearInterval(tid);
		Open();
		
		cnt=parseInt(10);
		nCountInit();
		logout();
	}
}

function nCountInit(){
	tid=setInterval("nCountRun()",1000);
}

function nCountRun(){
	document.all.ncounter.innerText=timeFormat(cnt);
	cnt--;
	if(cnt<0){
		logoutInfo();
	}
}

function countReset(){
	clearInterval(tid);
	cnt=parseInt(10);
	CountInit();
	document.all.ncounter.innerText="";
}

function logoutInfo(){
	self.location="../info/logoutInfo.jsp";
}

function logout(){
	self.location="../session/sessionLogin.jsp";
}


function timeFormat(s){
	var nHour=0;
	var nMin=0;
	var nSec=0;
	if(s>0){
		nMin=parseInt(s/60);
		nSec=s%60;
		if(nMin>60){
			nHour=parseInt(nMin/60);
			nMin=nMin%60;
		}
	}
	if(nSec<10)nSec="0"+nSec;
	if(nMin<10)nMin="0"+nMin;
	return ""+nHour+":"+nMin+":"+nSec;
}