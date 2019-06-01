const getConfigJson = function () {
  var json = new Object()
  var inputs = document.getElementsByTagName("input")
  for (let index = 0; index < inputs.length; index++) {
    const element = inputs[index]
    var key = element.name
    if (element.type === 'number')
      var value = element.value
    if (element.type === 'checkbox')
      var value = element.checked  ? element.value : ""
    json[key] = value
  }

  var textareas = document.getElementsByTagName("textarea")
  for (let index = 0; index < textareas.length; index++) {
    const element = textareas[index]
    json[element.name] = element.value
  }

  console.log(JSON.stringify(json))
  console.log(json)
  return json
}

export default getConfigJson