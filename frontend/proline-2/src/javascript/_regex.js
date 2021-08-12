
export const nameRegex = /^[\p{L}'][ \p{L}'-]*[\p{L}]$/ui
export const nameMsg = "Names can only have letters and cannot be empty."

// eslint-disable-next-line no-control-regex
export const emailRegex = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/i
export const emailMsg = "This is not a valid e-mail."

export const bioRegex = /^.+$/iu
export const bioMsg = "This field cannot be empty."

export const dateRegex = /^.+$/iu
export const dateMsg = "This field cannot be empty."

export const roleRegex = /^.+$/iu
export const roleMsg = "This field cannot be empty."

export const telRegex = /^(\+[0-9]{12}|[0-9]{11})$/iu
export const telMsg = "This is not a valid telephone"
