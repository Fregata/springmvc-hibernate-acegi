function next(step){
	if(step==='step1'){
		$("#step1-form").submit();
	}else if(step==='step2'){
		$("#step2-form").submit();
	}else if(step==='step3'){
		$("#step3-form").submit();
	}
};

function previous(step){
	if(step==='step2'){
		$("#sch-step2").hide();
		$("#sch-step1").show();
	}else if(step==='step3'){
		$("#sch-step3").hide();
		$("#sch-step2").show();
	}
	
};