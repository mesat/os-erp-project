<template>
  <div>
    <span v-for="value in arry">
      <CIcon name="cilStar"/>
      {{value}}
    </span>
    <CButton @click="click" color="success">
      aaaaa
    </CButton>
    <CAlert close-button @update:show="show">aaaaaaa</CAlert>
  </div>
</template>

<script>
import {axios} from "../javascript/_axios"


export default {
  name: "VueTest",
  data() {
    return {
      arry: []
    }
  },
  methods: {
    click() {
      this.arry += 'a'
    },
    show() {
      alert('a')
    }
  }
}
</script>

<style scoped>

</style>