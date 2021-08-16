<template>
  <div>
    
    <CDataTable :items="items" :fields="fields">
      <template #no-items-view>
        <div/>
      </template>
      <template #delete="{index}">
        <td>
          <CButton color="danger" @click="delete_item(index)" size="sm">-</CButton>
        </td>
      </template>
      <template #icon="{item}">
        <td>
          <CIcon :name="item.icon"/>
        </td>
      </template>
    </CDataTable>
    <CRow>
      <CCol sm="2">
        <CSelect :options="options" placeholder="<empty>" :value.sync="social"/>
      </CCol>
      <CCol sm="2">
        <CInput name="nick" placeholder="Nick" v-model="nick"/>
      </CCol>
      <CCol sm="7">
        <CInput name="link" type="url" placeholder="Link" v-model="link"/>
      </CCol>
      <CCol sm>
        <CButton color="success" @click="add">+</CButton>
      </CCol>
    </CRow>
  </div>
</template>

<script>
const fields = [{
  key: "icon",
  label: "",
  _classes: "col-0"
}, {
  key: "name",
  label: "Name",
  _classes: "col-1"
}, {
  key: "nick",
  label: "Nick",
  _classes: "col-1"
}, {
  key: "link",
  label: "Link",
  _classes: "col-9"
}, {
  key: "delete",
  label: '',
  _classes: "col-0"
}]

import socials from "./_socials"


export default {
  name: "Socials",
  props: ['value'],
  data() {
    return {
      items: [],
      fields: fields,
      socials: socials,
      social: '',
      nick: '',
      link: ''
    }
  },
  computed: {
    options() {
      return socials.map(function (s) {
        return {label: s.name, value: s}
      })
    }
  },
  watch: {
    value: function (newItems) {
      this.items = newItems
    }
  },
  methods: {
    add() {
      if (typeof(this.social.name) != "undefined" && this.nick !== '' && this.link !== '') {
        this.$emit('input', this.items)
        this.items.push({icon: this.social.icon, name: this.social.name, nick: this.nick, link: this.link})
      }
    },
    delete_item(id) {
      this.$emit('input', this.items)
      this.items.splice(id, 1)
    }
  }
}
</script>

<style scoped>

</style>