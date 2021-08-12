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
import {axios} from "../javascript/_axios";
import * as regex from "../javascript/_regex"
import Employee from "../javascript/_employee";

export default {
  name: "EditEmployee",
  data() {
    return {
      id: null,
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
    this.message.name= regex.nameMsg
    this.message.surName = regex.nameMsg
    this.message.date = regex.dateMsg
    this.message.role = regex.roleMsg
    this.message.bio = regex.bioMsg
    this.message.mail = regex.emailMsg
    this.message.tel = regex.telMsg

    axios.get('/employees/' + this.$route.params.id)
        .then((response) => {
          //this.item = new Employee(x['name'], x['surname'], '11/11/1111', x['rol'], x['bio']).setId(x['id'])
          let item = new Employee().parse(response.data)

          this.loading = false
        })
        .catch(function (error) {
          alert(error)
        })
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
        url: '/employees/' + this.$route.params.id,
        method: "PUT",
        data: data,
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(() => {
        this.name = ''
        this.surName = ''
        this.date = ''
        this.role = ''
        this.bio = ''
        this.tel = ''
        this.mail = ''
        this.socials = []
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
      return this.isValid(val, regex.dateRegex)
    },
    isValidRole(val) {
      return this.isValid(val, regex.roleRegex)
    },
    isValidBio(val) {
      return this.isValid(val, regex.bioRegex)
    },
    isValidMail(val) {
      return this.isValid(val, regex.emailRegex)
    },
    isValidTel(val) {
      return this.isValid(val, regex.telRegex)
    },
    isValidName(val) {
      return this.isValid(val, regex.nameRegex)
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