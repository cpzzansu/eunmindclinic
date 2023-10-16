<template>
  <div class="q-pa-md">
    <Search :search-query.sync="searchQuery"></Search>
    <q-btn
        label="회원등록"
        @click="openRegistrationForm = true"
        color="primary"
    />

    <q-dialog v-model="openRegistrationForm" persistent>
      <q-card>
        <q-card-section>
          <q-form @submit="submitForm">
            <q-input v-model="newMember.username" label="Name"/>
            <q-input v-model="newMember.email" label="Email" type="email"/>
            <q-input v-model="newMember.password" label="Password" type="password"/>
            <q-select v-model="newMember.roleId" :options="options" label="role" />
            <!-- Add other input fields as needed -->

            <div>
              <q-btn label="Register" type="submit" color="primary"/>
              <q-btn label="Cancel" @click="openRegistrationForm = false" flat/>
            </div>
          </q-form>
        </q-card-section>
      </q-card>
    </q-dialog>

    <q-table
        flat bordered
        title="회원정보"
        :rows="rows"
        :columns="columns"
        row-key="name"
        :selected-rows-label="getSelectedString"
        selection="multiple"
        v-model:selected="selected"
    />
  </div>
</template>

<script>
import {ref} from 'vue'
import Search from "@/components/Search.vue";
import axios from "axios";

export default {
  components: {
    Search
  },
  data() {
    return {
      openRegistrationForm: false,
      newMember: {
        username: '',
        email: '',
        password: '',
        roleId: ''
      },
      rows: [],
      columns: [
        {name: 'username', required: true, label: 'Username', field: 'username', sortable: true},
        {name: 'email', label: 'Email', field: 'email', sortable: true},
        {name: 'status', label: 'Status', field: 'status'},
        {name: 'rdate', label: 'Registration Date', field: 'rdate', sortable: true},
      ],
    };
  },
  methods: {
    getSelectedString() {
      return `${this.selected.length} selected`
    },
    submitForm() {
      axios.post('http://localhost:8080/api/users', this.newMember)
          .then(response => {
            // Update the table with the new user data
            this.rows.push(response.data);
          })
          .catch(error => {
            console.error('There was an error creating the user!', error);
          })
          .finally(() => {
            // Reset the form and close the modal
            this.newMember = {
              username: '',
              email: '',
              password: '',
              roleId: ''
            };
            this.openRegistrationForm = false;
          });
    }
  },
  mounted() {
    axios.get('http://localhost:8080/api/users')
        .then(response => {
          // Assign fetched data to rows
          this.rows = response.data;
        })
        .catch(error => {
          console.error('There was an error fetching the data!', error);
        });
  },
  setup() {
    const selected = ref([])
    const searchQuery = ref('');
    return {
      roleId: ref(null),
      options: [
        1, 2, 3
      ],
      searchQuery,
      selected,
    }
  }
}
</script>
