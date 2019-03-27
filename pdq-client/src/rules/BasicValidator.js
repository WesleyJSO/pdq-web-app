export default class BasicValidator {
  emptyComboField (t) {
    if (!t) {
      return ['Item deve ser selecionado!']
    }
  }
}