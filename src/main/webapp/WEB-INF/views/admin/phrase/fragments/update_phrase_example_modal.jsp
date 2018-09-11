<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Update Phrase Example Modal -->
<div class="modal fade" id="update-phrase-example-modal" tabindex="-1"
	role="dialog" aria-labelledby="update-phrase-example-modal-label"
	aria-hidden="true">
	
	<div class="modal-dialog" role="document">
		<form class="modal-content" method="post"
			action="/admin/phrase/save/phrase-example">
			
			<div class="modal-header">
				<h5 class="modal-title" id="update-phrase-example-modal-label">
					<spring:message
						code="admin.phrase.list.phrase_example.text.modal.update_phrase_example" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>
						<spring:message
							code="admin.phrase.list.phrase_example.text.modal.phrase_example_id" />
					</label>
					<input id="update-id" name="id" class="form-control"
						readonly="readonly">
				</div>
				<div class="form-group">
					<label>
						<spring:message
							code="admin.phrase.list.phrase_example.text.modal.phrase_id" />
					</label>
					<input id="update-pId" name="pId" class="form-control">
				</div>
				<div class="form-group">
					<label>
						<spring:message
							code="admin.phrase.list.phrase_example.text.modal.sentence_id" />
					</label>
					<input id="update-sId" name="sId" class="form-control">
				</div>
				<div class="form-group">
					<hr>
					<div id="update-phrase" class="text-success">
						<strong></strong>
					</div>
					<div id="update-phrase-meaning"></div>
					<div id="update-sentence" class="text-warning">
						<strong></strong>
					</div>
					<div id="update-sentence-meaning"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary">
					<spring:message
						code="admin.phrase.list.phrase_example.text.button.save" />
				</button>
				<button id="update-phrase-example-review-btn"
					class="btn btn-success">
					<spring:message
						code="admin.phrase.list.phrase_example.text.button.review" />
				</button>
			</div>
		</form>
	</div>
</div>