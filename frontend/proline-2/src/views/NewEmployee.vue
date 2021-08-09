<template>
  <CCard align="left">
    <CCardHeader>
      <h1>Create a new employee</h1>
    </CCardHeader>
    <CCardBody>
      <CRow>
        <CCol class="order-md-12">
          <img src="../assets/logo.png" alt="logo" height="150" width="150">
          <CInputFile custom/>
        </CCol>

        <CCol md="9" class="order-md-0">
          <CRow>
            <CCol>
              <CInput
                  name="name"
                  label="Name"
                  placeholder="Enter employees name"
                  :invalidFeedback= "message.name"
                  :isValid="isValidName"
                  v-model="name"
                  lazy="false"
              />
            </CCol>
            <CCol>
              <CInput
                  name="last-name"
                  label="Surname"
                  placeholder="Enter employees surname"
                  invalidFeedback= ""
                  tooltipFeedback="true"
                  :isValid = "isValidName"
                  v-model="surName"
              />
            </CCol>
            <CRow>
              <CCol>
                <CInput
                    label="Date"
                    type="date"
                    v-model="date"
                    invalidFeedback= "message.date"
                    tooltipFeedback="true"
                    :isValid = "isValidDate"
                />
              </CCol>
            </CRow>
          </CRow>
          <CRow md="2">
            <CInput
                name="role"
                label="Role"
                placeholder="Role in the company"
                invalidFeedback= ""
                tooltipFeedback="true"
                :isValid = "isValidRole"
                v-model="role"
            />
          </CRow>
          <CRow>
            <CCol>
              <CTextarea
                  name="bio"
                  label="Bio"
                  rows="8"
                  placeholder="Short bio of the employee..."
                  invalidFeedback= ""
                  tooltipFeedback="true"
                  :isValid = "isValidBio"
                  v-model="bio"
              />
            </CCol>
          </CRow>
        </CCol>


      </CRow>

    </CCardBody>
    <CCardHeader>
      <h2>Communication Info</h2>
    </CCardHeader>
    <CCardBody>
      <CInput
          name="tel"
          label="Telephone Number"
          type="mail"
          placeholder="Telephone number"
          :invalidFeedback= "message.tel"
          tooltipFeedback="true"
          :isValid = "isValidTel"
      />
      <CInput
          name="e-mail"
          label="E-Mail"
          type="tel"
          placeholder="Enter mail"
          invalidFeedback= ""
          tooltipFeedback="true"
          :isValid = "isValidMail"
      />
    </CCardBody>
    <CCardHeader>
      <strong>Social media</strong>
    </CCardHeader>
    <CCardBody>
      <Socials v-model="socials"/>
    </CCardBody>
    <CCardFooter>
      <CRow>
        <CCol col="0" md="10"/>
        <CCol md="2">
          <CButton block color="success" @click="submit">Submit</CButton>
        </CCol>
      </CRow>
    </CCardFooter>
  </CCard>
</template>

<script>
import Socials from "../components/Socials";

const nameRegex = /^[A-Za-z]+$/i
const nameMsg = "Names can only have letters and cannot be empty."

const emailRegex = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/i
const emailMsg = "This is not a valid e-mail."

const bioRegex = /^.+$/i
const bioMsg = "This field cannot be empty."

const dateRegex = /^.+$/i
const dateMsg = "This field cannot be empty."

const roleRegex = /^.+$/i
const roleMsg = "This field cannot be empty."

const telRegex = /^(\+[0-9]{12}|[0-9]{11})$/i
const telMsg = "This is not a valid telephone"


export default {
  name: "NewEmployee",
  data() {
    return {
      name: "",
      surName: "",
      date: "",
      role: "",
      bio: "",
      socials: [],
      valid: {},
      message: {}
    }
  },
  created() {
    this.message.name= nameMsg
    this.message.surName = nameMsg
    this.message.date = dateMsg
    this.message.role = roleMsg
    this.message.bio = bioMsg
    this.message.mail = emailMsg
    this.message.tel = telMsg
  },
  methods: {
    submit() {

    },
    isValid(val, regex) {
      if(val === '' || val === undefined)
      {
        return null
      }
      else return val.match(regex) !== null;
    },
    isValidDate(val) {
      return this.isValid(val, dateRegex)
    },
    isValidRole(val) {
      return this.isValid(val, roleRegex)
    },
    isValidBio(val) {
      return this.isValid(val, bioRegex)
    },
    isValidMail(val) {
      return this.isValid(val, emailRegex)
    },
    isValidTel(val) {
      return this.isValid(val, telRegex)
    },
    isValidName(val) {
      return this.isValid(val, nameRegex)
    },
  },
  components: {
    Socials
  }
}
</script>

<style scoped lang="scss">
div {
  text-align: left;
}


</style>