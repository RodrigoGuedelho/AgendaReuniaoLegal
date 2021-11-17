function mascara(o, f) {
    v_obj = o;
    v_fun = f;
    setTimeout("execmascara()", 1);
}
function execmascara() {
    v_obj.value = v_fun(v_obj.value);
}
function soLetras(v) {
    return v.replace(/[^a-zA-Z ]/g, "");
}
function soNumeros(v) {
    return v.replace(/[^0-9]/, "");
}
function numerosCaractere(v) {
    return v.replace(/[^0-9-]/, "");
}
function numerosCaractere2(v) {
    return v.replace(/[^0-9-;,]/, "");
}