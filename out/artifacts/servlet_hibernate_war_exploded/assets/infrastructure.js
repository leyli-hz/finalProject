function removeEntity(entityName,id) {
    if (confirm('are u sure?'))
        window.location = '/'+entityName+'/remove.do?id=' + id;
}