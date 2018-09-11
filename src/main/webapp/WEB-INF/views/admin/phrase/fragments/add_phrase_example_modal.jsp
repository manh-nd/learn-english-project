<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Add Phrase Example Modal -->

<div class="modal fade" id="add-phrase-example-modal" tabindex="-1"
	role="dialog" aria-labelledby="add-phrase-example-modal-label"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<form class="modal-content" method="post"
			action="/admin/phrase/save/phrase-example">
			<div class="modal-header">
				<h5 class="modal-title" id="add-phrase-example-modal-label">
					<spring:message
						code="admin.phrase.list.phrase_example.text.modal.add_new_phrase_example" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<input id="add-id" type="hidden" value="">
				<div class="form-group">
					<label>
						<spring:message
							code="admin.phrase.list.phrase_example.text.modal.phrase_id" />
					</label>
					<input id="add-pId" name="pId" class="form-control">
				</div>
				<div class="form-group">
					<label>
						<spring:message
							code="admin.phrase.list.phrase_example.text.modal.sentence_id" />
					</label>
					<input id="add-sId" name="sId" class="form-control">
				</div>
				<div class="form-group">
					<hr>
					<div id="add-phrase" class="text-success">
						<strong></strong>
					</div>
					<div id="add-phrase-meaning"></div>
					<div id="add-sentence" class="text-warning">
						<strong></strong>
					</div>
					<div id="add-sentence-meaning"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary">
					<spring:message
						code="admin.phrase.list.phrase_example.text.button.save" />
				</button>
				<button id="add-phrase-example-review-btn" class="btn btn-success">
					<spring:message
						code="admin.phrase.list.phrase_example.text.button.review" />
				</button>
			</div>
		</form>
	</div>
</div>