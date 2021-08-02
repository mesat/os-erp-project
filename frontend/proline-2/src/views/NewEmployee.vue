<template>
  <CCard align="left">
    <CCardHeader>
      <h1>Create a new employee</h1>
    </CCardHeader>
    <CCardBody>
      <CRow>
        <CCol xl="9">
          <CRow>
            <CCol>
              <CInput name="name" label="Name" placeholder="Enter employees name"/>
            </CCol>
            <CCol>
              <CInput name="last-name" label="Surname" placeholder="Enter employees surname"/>
            </CCol>
          </CRow>
          <CRow md="2">
            <CInput name="role" label="Role" placeholder="Role in the company"/>
          </CRow>
        </CCol>
        <CCol>
          <img src="../assets/logo.png" alt="logo" height="150" width="150">
        </CCol>
      </CRow>
      <CRow>
        <CCol md="9">
          <CTextarea name="bio" label="Bio" rows="10" placeholder="Short bio of the employee..."/>
        </CCol>
        <CCol>
          <CInputFile custom/>
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
      <Socials v-model="socials" @input="sin"/>
    </CCardBody>

  </CCard>

</template>

<script>
import Socials from "../components/Socials";

export default {
  name: "NewEmployee",
  data() {
    return {
      socials: []
    }
  },
  methods: {
    sin() {

    }
  },
  components: {
    Socials
  }
}
</script>

<style scoped>
div {
  text-align: left;
}
</style>