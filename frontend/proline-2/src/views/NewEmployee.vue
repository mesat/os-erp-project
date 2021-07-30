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
          <CInput type="file" name="img" label="Image"></CInput>
        </CCol>
      </CRow>
    </CCardBody>
    <CCardHeader>
      <strong>Communication Info</strong>
    </CCardHeader>
    <CCardBody>
      <Socials/>
    </CCardBody>

  </CCard>

</template>

<script>
import Socials from "../components/Socials";
export default {
  name: "NewEmployee",
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