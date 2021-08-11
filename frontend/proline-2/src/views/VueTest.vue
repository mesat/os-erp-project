<template>
  <div>
    <h1 style="color: red">
      DELETE ALL EMPLOYEES
    </h1>
    <CInput placeholder="password" v-model="passwd"/>
    <CButton @click="click" color="success">
      The Big Red Button
    </CButton>
  </div>
</template>

<script>
import {axios} from "../javascript/_axios"
import Employee from "../javascript/_employee";


export default {
  name: "VueTest",
  data() {
    return {
      arry: [],
      passwd:''
    }
  },
  methods: {
    click() {
      if(this.passwd==='çernobil') {
        axios.get("/employees")
            .then((response) => {
              response.data.map(function (x) {
                //return new Employee(x['name'], x['surname'], '11/11/1111', x['rol'], x['bio']).setId(x['id'])
                return x['id']
              }).forEach((x) => {
                axios.delete("/employees/"+x)
              })
            })

      }
    },
    show() {
      alert('a')
    }
  }
}
</script>

<style scoped>

</style>