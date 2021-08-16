<template>
  <div id="name">


    <div id="teamBoard">
      <!--
      <h1 style="opacity: 50%" v-if="teamName.match(/^\s*$/)">
        Write a name for the team!
      </h1>
      <h1 v-else>
        {{ teamName }}<span style="opacity: 0">patates</span>
      </h1>-->
      <h1>
        <input id="teamName" type="text" placeholder="Write the team name here!"/>
      </h1>
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
    </div>
    <CRow alignHorizontal="end" >
      <CCol col="1">
        <CButton color="success" v-on:click="submit"> Submit
        </CButton>
      </CCol>

      <CCol col="1">
        <CButton color="warning" v-on:click="clearTeam" v-if="showClear">Clear Team
        </CButton>
      </CCol>
    </CRow>
    <EmployeeSelect :emp="employees" :loading="loading" :dont="dont">
      <template #cardActions="{item}">
        <CRow>
          <CCol col="12">
            <CButton variant="outline" size="sm" shape="pill" color="success" @click="addToTeam(item.item)">
              Add to team
            </CButton>
          </CCol>
        </CRow>
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
  data() {
    return {
      team: [],
      teamName: '',
      employees: [],
      loading: false,

    }
  },
  methods: {
    addToTeam(a) {
      this.team.push(a)
    },
    remove(item) {/*
      this.team = this.team.filter(function (a) {
        return a.id !== item.id
      })*/
      this.team.splice(this.team.findIndex(function (a) {
        return a.id === item.id
      }), 1)
    },
    makeLeader(item) {
      this.remove(item)
      this.team.unshift(item)
    },
    submit() {

    },
    clearTeam() {
      this.team.splice(0, this.team.length)
    }
  },
  computed: {
    notEmpty() {
      return this.team.length !== 0
    },
    showClear() {
      return this.team.length !== 0
    },
    dont() {
      console.log(this.team.map(function (a) {
        return a.id
      }))
      return this.team.map(function (a) {
        return a.id
      })
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
}

</script>

<style scoped lang="scss">
#teamBoard {
  background: #ddd;
  border-radius: 10px;
  min-height: 350px;
  padding: 10px;
  margin: 20px 0;
  z-index: 0;
  strong {
    margin: auto;
  }
}

#teamName {
  background: #0000;
  border: none;
  width: 100%;
  color: var(--cui-headings-color,unset);
  font-size: 2.1875rem;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
  font-weight: 500;
}
#teamName:focus {
  outline: none;
}

#star {
  position: absolute;
  width: 30px;
  height: 30px;
  z-index: 2;
  top: 10px;
  left: 10px;
}

#selectedTeam {
  position: relative;
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

.team-enter-active {

  transition: opacity .3s;
}

.team-leave-active {
  position: absolute;
  transition: opacity .3s;
}

.team-enter, .team-leave-to /* .team-leave-active below version 2.1.8 */
{
  opacity: 0;
}


.team-move {
  transition: transform 0.5s;
}

.team-item {
  transition: all .3s;
  display: inline-block;
}
</style>
