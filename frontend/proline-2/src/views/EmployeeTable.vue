<template>
  <div>
    <EmployeeSelect :emp="employees" :loading="loading">
      <template #cardActions="{item}">
          <CCol class="ccol">
            <CButton variant="outline" size="sm" shape="pill" color="success" :to="'/view/'+item.item.id">
              View
            </CButton>
          </CCol>

          <CCol class="ccol">
            <CButton variant="outline" size="sm" shape="pill" color="primary" :to="'/edit/'+item.item.id">
              Edit
            </CButton>
          </CCol>
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
    axios.get("/employees")
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
.ccol {
  justify-content: center;
  display: flex;
}
</style>