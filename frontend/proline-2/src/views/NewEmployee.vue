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
              />
            </CCol>
            <CCol>
              <CInput
                  name="last-name"
                  label="Surname"
                  placeholder="Enter employees surname"
                  invalidFeedback= ""
                  tooltipFeedback
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
                    tooltipFeedback
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
                tooltipFeedback
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
                  tooltipFeedback
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
          v-model="tel"
          tooltipFeedback
          :isValid = "isValidTel"
      />
      <CInput
          name="e-mail"
          label="E-Mail"
          type="tel"
          placeholder="Enter mail"
          invalidFeedback= ""
          tooltipFeedback
          v-model="mail"
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
        <CCol col="0" md="10">
          <CAlert color="danger" close-button  :show.sync="showError">
            {{warning}}
          </CAlert>
        </CCol>
        <CCol md="2">
          <CSpinner color="success" v-if="loading"/>
          <CButton block color="success" @click="submit" v-else>Submit</CButton>
        </CCol>
      </CRow>
    </CCardFooter>
  </CCard>
</template>

<script>
import Socials from "../components/Socials";
import {axios} from "../javascript/_axios"
const nameRegex = /^[\p{L}'][ \p{L}'-]*[\p{L}]$/ui
const nameMsg = "Names can only have letters and cannot be empty."

// eslint-disable-next-line no-control-regex
const emailRegex = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/i
const emailMsg = "This is not a valid e-mail."

const bioRegex = /^.+$/iu
const bioMsg = "This field cannot be empty."

const dateRegex = /^.+$/iu
const dateMsg = "This field cannot be empty."

const roleRegex = /^.+$/iu
const roleMsg = "This field cannot be empty."

const telRegex = /^(\+[0-9]{12}|[0-9]{11})$/iu
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
      message: {},
      tel: '',
      mail: '',
      loading: false,
      warning: '',
      showError: false
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
      this.loading = true
      let data = {
        "name": this.name,
        "surname": this.surName,
        "rol": this.role,
        "bio": this.bio,
        "contactsById": [
          {
            "link": this.tel,
            "socialmediaBySocialmediaPlatform": {
              "platform": "TEL_NO",
            }
          },
          {
            "link": this.mail,
            "socialmediaBySocialmediaPlatform": {
              "platform": "MAIL"
            }
          }
        ].concat(this.socials.map(function (a) {
          return {
            "link": a.link,
            "socialmediaBySocialmediaPlatform": {
              "platform": a.name
            }
          }
        }))
      }
      console.log(data);
      axios.request({
        url: '/employees',
        method: "POST",
        data: data,
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(() => {
        this.loading = false
      }).catch((error) => {
        this.showAlert(error)
        this.loading = false
      })
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
    showAlert(text) {
      this.showError = true
      this.warning = text
    }
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