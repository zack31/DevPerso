$().ready(function() {
			var opts = {
				cssClass : 'el-rte',
				// lang     : 'ru',
				height   : 450,
				toolbar  : 'complete',
				cssfiles : ['css/elrte-inner.css']
			}
			$('#editor').elrte(opts);
		})