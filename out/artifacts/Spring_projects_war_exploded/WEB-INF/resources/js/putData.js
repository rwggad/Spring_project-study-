function Request(DataSet) {
    $.ajax({
        type : Post,
        url : "PetClinic/Find",
        data : DataSet
    });
}