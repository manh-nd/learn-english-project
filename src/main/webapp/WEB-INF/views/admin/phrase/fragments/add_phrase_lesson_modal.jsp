<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Add phrase lesson modal -->
<div class="modal fade" id="phrase-lesson-modal" tabindex="-1"
	role="dialog" aria-labelledby="phrase-lesson-modal-label"
	aria-hidden="true">
	
	<div class="modal-dialog" role="document">
	
		<form class="modal-content" method="post"
			action="/admin/phrase/save/phrase-lesson">
			
			<div class="modal-header">
				<h5 class="modal-title" id="phrase-lesson-modal-label">
					<spring:message
						code="admin.phrase.list.phrase_example.text.modal.add_to_phrase_lesson" />
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
							code="admin.phrase.list.phrase_example.text.modal.phrase_detail_id" />
					</label>
					<input id="phrase-detail-id" name="phrase-detail-id" class="form-control"
						readonly="readonly">
				</div>
				<div class="form-group">
					<label>
						<spring:message
							code="admin.phrase.list.phrase_example.text.modal.lesson" />
					</label>
					<input id="phrase-lesson" name="phrase-lesson" class="form-control">
				</div>
				<div class="form-group">
					<label>
						<spring:message
							code="admin.phrase.list.phrase_example.text.modal.phrase_order" />
					</label>
					<input id="phrase-order" name="phrase-order" class="form-control">
				</div>
			</div>
			
			<div class="modal-footer">
				<button class="btn btn-primary">
					<spring:message
						code="admin.phrase.list.phrase_example.text.button.save" />
				</button>
				<button id="review-phrase-lesson-btn" class="btn btn-success">
					<spring:message
						code="admin.phrase.list.phrase_example.text.button.review" />
				</button>
			</div>
			
		</form>
	</div>
</div>