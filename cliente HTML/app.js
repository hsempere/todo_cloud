const { createApp, ref, onMounted } = Vue;

const app = createApp({
    data() {
        return {
			title: "TODOS website client",
			result: "",
			newtitle: "",
            todos: []
        };
    },
    mounted() {
        this.getAll();
    },
    methods: {
        getAll() {
            axios.get('http://localhost:8080/TODO')
			.then(response => {
				this.todos = response.data;
			})
			.catch(error => {
				console.error('Error fetching data:', error);
			});
        },
		post() {
			
			axios.post('http://localhost:8080/TODO', null, {
                params: {
                    title: this.newtitle
                }
			}).then(response => {
				this.todos.push(response.data);
				this.newtitle='';
				this.result="Nuevo TODO añadido correctamente.";
			})
			.catch(error => {
				console.error('Error inserting TODO:', error);
			});
		}
    }
});

app.mount('#app');
