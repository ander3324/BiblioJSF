var title;
var from;
$('#abrirBtn').click(function () {
    $('#lblDlg').html(title);
    $('.modal-body').load(from, function (result) {
        $('#dlgAbm').modal({show: true});
    });
});

function modal(title, form) {
    title = title;
    from = form;
    $('#abrirBtn').click();
}


