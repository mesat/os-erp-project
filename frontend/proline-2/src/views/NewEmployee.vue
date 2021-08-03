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
              <CInput name="name" label="Name" placeholder="Enter employees name" v-model="name"/>
            </CCol>
            <CCol>
              <CInput name="last-name" label="Surname" placeholder="Enter employees surname" v-model="surName"/>
            </CCol>
            <CRow>
              <CCol>
                <CInput label="Date" type="date" v-model="date"/>
              </CCol>
            </CRow>
          </CRow>
          <CRow md="2">
            <CInput name="role" label="Role" placeholder="Role in the company" v-model="role"/>
          </CRow>
          <CRow>
            <CCol>
              <CTextarea name="bio" label="Bio" rows="8" placeholder="Short bio of the employee..." v-model="bio"/>
            </CCol>
          </CRow>
        </CCol>


      </CRow>

    </CCardBody>
    <CCardHeader>
      <h2>Communication Info</h2>
    </CCardHeader>
    <CCardBody>
      <CInput name="tel" label="Telephone Number" type="mail" placeholder="Telephone number"/>
      <CInput name="e-mail" label="E-Mail" type="tel" placeholder="Enter mail"/>
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

export default {
  name: "NewEmployee",
  data() {
    return {
      name: "",
      surName: "",
      date: "",
      role: "",
      bio: "",
      socials: []
    }
  },
  methods: {
    submit () {
      alert(this.date)
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