<template>
  <div>
    <EmployeeSelect :emp="employees" :loading="loading">
      <template #cardActions="{item}">
        <CCol col="2">
          <CButton variant="outline" size="sm" shape="pill" color="success" :to="'/view/'+item.item.id">
            View
          </CButton>
        </CCol>
        <CCol col="10"/>
      </template>
    </EmployeeSelect>
  </div>
</template>
<script>

import EmployeeSelect from "../components/EmployeeSelect";
import Employee from "../javascript/_employee"
import {axios} from "../javascript/_axios"

export default {
  name: "EmployeeTable",
  components: {
    EmployeeSelect
  },
  data() {
    return {
      employees: [],
      loading: false
    }
  },
  mounted() {
    this.loading = true
    axios.get("/api/employees")
        .then((response) => {
          this.employees = response.data.map(function (x) {
            //return new Employee(x['name'], x['surname'], '11/11/1111', x['rol'], x['bio']).setId(x['id'])
            return new Employee().parse(x)
          })
          this.loading = false
        })
  },
  methods: {
    click() {
      console.log(this.employees)
    }
  }
}
</script>

<style scoped lang="scss">

</style>