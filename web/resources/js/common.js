function gfn_isNUll(str) {
    if(str == null)
        return true;
    if(str == "NaN")
        return true;
    if(new String(str).valueOf() == "undefined")
        return true;
    var chkstr = new String(str)
    if(chkstr.valueOf() == "undefined")
        return true;
    if(chkstr == null)
        return true;
    if(chkstr.toString().length == 0)
        return true;
    return false;
}
function ComSubmit(opt_formId) {
    this.formId = gfn_isNUll(opt_formId) == true ? "commonForm" : opt_formId;
    this.url = "";

    if(this.formId == "commonForm"){
        $("#commonForm")[0].reset();
    };

    this.setUrl = function setUrl(url) {
        this.url = url;
    };

    this.addParam = function addParam(key, value) {
        $("#" + this.formId).append(
            $("<input type='hidden' name='" + key + "' id='" + key + "' value= '"+ value +"' />"));
    };

    this.submit = function submit() {
        var frm = $("#" + this.formId)[0];
        frm.action = this.url;
        frm.method = "post";
        frm.submit();
    };

}