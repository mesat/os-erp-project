<template>
  <div>
    <CDataTable :items="items" :fields="fields">
      <template #no-items-view>
        <div/>
      </template>
    </CDataTable>
    <CRow>
      <CCol sm="2">
        <CSelect :options="socials" placeholder="<empty>" />
      </CCol>
      <CCol sm="2">
        <CInput name="nick" placeholder="Nick"/>
      </CCol>
      <CCol sm="7">
        <CInput name="link" placeholder="Link" />
      </CCol>
      <CCol sm>
        <CButton color="success">+</CButton>
      </CCol>
    </CRow>
  </div>
</template>

<script>
const fields = [{
  key: "name",
  label: "Name",
  _classes: "col-md-2"
}, {
  key: "nick",
  label: "Nick",
  _classes: "col-md-2"
}, {
  key: "link",
  label: "Link",
  _classes: "col-md-8"
}]

import socials from "./_socials"



export default {
  name: "Socials",
  data () {
    return {
      items: [],
      fields: fields,
      socials: socials
    }
  }
}
</script>

<style scoped>

</style>