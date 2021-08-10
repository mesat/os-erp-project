<template>
  <div id="name">
    <h1>
      {{ teamName }}
    </h1>
    <!--
    <p v-bind:style="{fontSize:boyut + 'px'}">{{teamName}}</p>
      v-bind
    -->
    <div id="selectedTeam">
      <CIcon name="cilStar" id="star" v-if="notEmpty"/>
      <transition-group name="team" id="transitionSpan">
      <EmployeeCard v-for="item in team" class="team-item" :item="item" :key="item.id">
        <template #cardActions="{item}">
          <CCol col="8">
            <CButton variant="outline" size="sm" shape="pill" color="warning" @click="makeLeader(item)">
              <nobr>Make Leader</nobr>
            </CButton>
          </CCol>
          <CCol col="4">
            <CButton variant="outline" size="sm" shape="pill" color="danger" @click="remove(item)">
              X
            </CButton>
          </CCol>
        </template>
      </EmployeeCard>
      </transition-group>
    </div>
    <CRow>
      <CCol>
        <CInput v-model="teamName" placeholder="team name"/>

      </CCol>

      <CCol col="2">
        <CButton color="success" v-on:click="summit"> Summit
        </CButton>
      </CCol>

      <CCol col="2">
        <CButton color="warning" v-on:click="clearTeam" v-if="showClear"> Clear Team
        </CButton>
      </CCol>
    </CRow>
    <EmployeeSelect :emp="employees" :loading="loading">
      <template #cardActions="{item}">
        <CCol col="12">
          <CButton variant="outline" size="sm" shape="pill" color="success" @click="addToTeam(item.item)">
            Add to team
          </CButton>
        </CCol>
      </template>
    </EmployeeSelect>


  </div>


</template>

<script>
import EmployeeSelect from "../components/EmployeeSelect";
import EmployeeCard from "../components/EmployeeCard";
import {axios} from "../javascript/_axios";
import Employee from "../javascript/_employee";

export default {
  name: "CreateTeam",
  components: {
    EmployeeSelect,
    EmployeeCard
  },
  data () {
    return {
      team: [],
      teamName: '',
      employees: [],
      loading: false
    }
  },
  methods: {
    addToTeam(a) {
      this.team.push(a)
    },
    remove (item) {/*
      this.team = this.team.filter(function (a) {
        return a.id !== item.id
      })*/
      this.team.splice(this.team.findIndex(function (a) {
        return a.id === item.id
      }), 1)
    },
    makeLeader (item) {
      this.remove(item)
      this.team.unshift(item)
      console.log(this.team)
    },
    clearTeam() {
      this.team.splice(0,this.team.length)
    }
  },
  computed: {
    notEmpty () {
      return this.team.length !== 0
    },
    showClear () {
      return this.team.length !==0
    }
  },
  mounted() {
    this.loading = true
    axios.get("/api/employees")
        .then((response) => {
          this.employees = response.data.map(function (x) {
            return new Employee(x['name'], x['surname'], '11/11/1111', x['rol'], x['bio']).setId(x['id'])
          })
          this.loading = false
        })
  },
}

</script>

<style scoped lang="scss">
#selectedTeam {
  display: flex;
  flex-wrap: wrap;
  background: #ddd;
  border-radius: 10px;
  min-height: 100px;
  padding: 5px;
  margin: 20px 0;
  z-index: 0;
  position: relative;
  strong {
    margin: auto;
  }

}
#star{
  position: absolute;
  width: 30px;
  height: 30px;
  z-index: 2;
  top: 10px;
  left: 10px;
}
#transitionSpan {
  display: flex;
  width: 100%;
  height: 100%;
  .card {
    flex: 0 0 150px;
    margin: 2px;
    height: 280px;
  }
}
.team-enter-active, .team-leave-active {
  transition: opacity .3s;
}

.team-enter, .team-leave-to /* .team-leave-active below version 2.1.8 */
{
  opacity: 0;
}

.team-move {
  transition: transform 0.5s;
}
</style>
