<div id="modalPanel" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="modalLabel" aria-hidden="true">
	
	<input type="hidden" value="${clientInstance.id}"/>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="modalLabel">${headerTitle}</h3>
	</div>
	<div class="modal-body">
		<p>${bodyContent}</p>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">No</button>
		<button class="btn btn-primary">Yes</button>
	</div>
</div>